import runner.UserInputAction
import io.accelerate.client.queue.QueueBasedImplementationRunner
import io.accelerate.client.runner.ChallengeSession
import runner.Utils.getConfig
import runner.Utils.getRunnerConfig
import com.fasterxml.jackson.module.kotlin.KotlinModule
/**
 * ~~~~~~~~~~ Running the system: ~~~~~~~~~~~~~
 *
 *   From IDE:
 *      Run this file from the IDE.
 *
 *   From command line:
 *      ./gradlew run
 *
 *   To run your unit tests locally:
 *      ./gradlew test -i
 *
 * ~~~~~~~~~~ The workflow ~~~~~~~~~~~~~
 *
 *   By running this file you interact with a challenge server.
 *   The interaction follows a request-response pattern:
 *        * You are presented with your current progress and a list of actions.
 *        * You trigger one of the actions by typing it on the console.
 *        * After the action feedback is presented, the execution will stop.
 *
 *   +------+-----------------------------------------------------------------------+
 *   | Step | The usual workflow                                                    |
 *   +------+-----------------------------------------------------------------------+
 *   |  1.  | Run this file.                                                        |
 *   |  2.  | Start a challenge by typing "start".                                  |
 *   |  3.  | Read the description from the "challenges" folder.                    |
 *   |  4.  | Locate the file corresponding to your current challenge in:           |
 *   |      |   ./src/main/kotlin/solutions                                         |
 *   |  5.  | Replace the following placeholder exception with your solution:       |
 *   |      |   TODO("Solution not implemented")                                    |
 *   |  6.  | Deploy to production by typing "deploy".                              |
 *   |  7.  | Observe the output, check for failed requests.                        |
 *   |  8.  | If passed, go to step 1.                                              |
 *   +------+-----------------------------------------------------------------------+
 *
 *   You are encouraged to change this project as you please:
 *        * You can use your preferred libraries.
 *        * You can use your own test framework.
 *        * You can change the file structure.
 *        * Anything really, provided that this file stays runnable.
 *
 **/
fun main(args: Array<String>) {
    val entry = EntryPointMapping()

    val runner = QueueBasedImplementationRunner.Builder()
        .setConfig(getRunnerConfig())
        .withSolutionFor("sum", entry::sum)
        .withSolutionFor("hello", entry::hello)
        .withSolutionFor("fizz_buzz", entry::fizzBuzz)
        .withSolutionFor("checkout", entry::checkout)
        .withSolutionFor("rabbit_hole", entry::rabbitHole)
        .withSolutionFor("amazing_maze", entry::amazingMaze)
        .withSolutionFor("ultimate_maze", entry::ultimateMaze)
        .withSolutionFor("increment", entry::increment)
        .withSolutionFor("to_uppercase", entry::toUppercase)
        .withSolutionFor("letter_to_santa", entry::letterToSanta)
        .withSolutionFor("count_lines", entry::countLines)
        .withSolutionFor("array_sum", entry::arraySum)
        .withSolutionFor("int_range", entry::intRange)
        .withSolutionFor("filter_pass", entry::filterPass)
        .withSolutionFor("inventory_add", entry::inventoryAdd)
        .withSolutionFor("inventory_size", entry::inventorySize)
        .withSolutionFor("inventory_get", entry::inventoryGet)
        .withSolutionFor("waves", entry::waves)
        .withJacksonModule(KotlinModule.Builder().build())
        .create()

    ChallengeSession.forRunner(runner)
        .withConfig(getConfig())
        .withActionProvider(UserInputAction(args))
        .start()
}

