package pl.akvelon.akvelontask

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.http.MediaType
import pl.akvelon.akvelontask.controller.creature.CreatureDrinkCommand
import pl.akvelon.akvelontask.exception.NotFoundException
import pl.akvelon.akvelontask.model.container.Container
import pl.akvelon.akvelontask.model.container.ContainerType
import pl.akvelon.akvelontask.model.container.bottle.Bottle
import pl.akvelon.akvelontask.model.creature.Creature
import pl.akvelon.akvelontask.model.creature.CreatureType
import pl.akvelon.akvelontask.model.creature.man.Man
import pl.akvelon.akvelontask.repository.container.ContainerRepository
import pl.akvelon.akvelontask.repository.container.ContainerRepositoryManager
import pl.akvelon.akvelontask.repository.creature.CreatureRepository
import pl.akvelon.akvelontask.repository.creature.CreatureRepositoryManager
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static pl.akvelon.akvelontask.RequestTestUtil.toJson

class CreatureDrinkControllerSpecIT extends WebMvcSpecification {

    @Autowired
    private CreatureRepositoryManager creatureRepositoryManager

    @Autowired
    private ContainerRepositoryManager containerRepositoryManager

    @Autowired
    private List<CreatureRepository<? extends Creature>> creatureRepositories

    @Autowired
    private List<ContainerRepository<? extends Container>> containerRepositories

    @Unroll
    def "it should move defined volume of liquid from container to creature given correct data - #description"() {
        given: "existing creature and container"
        def creatureIds = setupCreatures()
        def containerIds = setupContainers()

        and: "Valid request data"
        def volume = 10
        def creatureId = creatureIds.get(creatureType)
        def containerId = containerIds.get(containerType)
        def command = new CreatureDrinkCommand(
                creatureId: creatureId,
                creatureType: creatureType,
                containerId: containerId,
                containerType: containerType,
                volume: volume,
        )

        when: "Drink operation is performed"
        def result = mockMvc.perform(
                post("/creature/drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(command))
        )

        then: "Operation is successful"
        result.andExpect(status().isNoContent())

        and: "volume is updated"
        def creature = creatureRepositoryManager.getRepository(creatureType).findById(creatureId)
                .orElseThrow({ -> new NotFoundException(Creature.class) })
        creature.currentVolume == volume

        and:
        def container = containerRepositoryManager.getRepository(containerType).findById(containerId)
                .orElseThrow({ -> new NotFoundException(Container.class) })
        container.currentVolume == container.maxVolume - volume


        where:
        creatureType     | containerType        | description
        CreatureType.MAN | ContainerType.BOTTLE | "from BOTTLE to MAN"
        // Here put more Creatures and Containers to test
    }

    @Unroll
    def "it should not move defined volume of liquid from container to creature given too large volume for container - #description"() {
        given: "existing creature and container"
        def creatureIds = setupCreatures()
        def containerIds = setupContainers()

        and: "Invalid request data"
        def volume = 1000
        def creatureId = creatureIds.get(creatureType)
        def containerId = containerIds.get(containerType)
        def command = new CreatureDrinkCommand(
                creatureId: creatureId,
                creatureType: creatureType,
                containerId: containerId,
                containerType: containerType,
                volume: volume,
        )

        when: "Drink operation is performed"
        def result = mockMvc.perform(
                post("/creature/drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(command))
        )

        then: "Operation failed"
        result.andExpect(status().isBadRequest())

        where:
        creatureType     | containerType        | description
        CreatureType.MAN | ContainerType.BOTTLE | "from BOTTLE to MAN"
        // Here put more Creatures and Containers to test
    }

    void setup() {
        setupCreatures()
        setupContainers()
    }

    private def setupCreatures() {
        def ids = new HashMap<CreatureType, Long>()
        ids.put(CreatureType.MAN, setupMan().id)
        // Here put more Creatures to test
        return ids
    }

    private def setupMan() {
        def man = new Man(
                currentVolume: 0,
                maxVolume: 100,
                type: CreatureType.MAN
        )
        return creatureRepositoryManager.saveCreature(man)
    }

    private def setupContainers() {
        def ids = new HashMap<ContainerType, Long>()
        ids.put(ContainerType.BOTTLE, setupBottle().id)
        // Here put more Containers to test
        return ids
    }

    private def setupBottle() {
        def bottle = new Bottle(
                currentVolume: 100,
                maxVolume: 100,
                type: ContainerType.BOTTLE
        )
        return containerRepositoryManager.saveContainer(bottle)
    }

    void cleanup() {
        creatureRepositories.forEach(CrudRepository.&deleteAll)
        containerRepositories.forEach(CrudRepository.&deleteAll)
    }

}