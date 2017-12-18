# Template for cls-scala projects using Play and Git

This will setup a [cls-scala](https://github.com/combinators/cls-scala) project, 
presenting inhabitants and hosting them via git using [cls-scala-presentation-play-git](https://github.com/combinators/cls-scala-presentation-play-git).

## Usage
1. Type in
    ```
    sbt new combinators/cls-scala-project.g8
    ```

and answer the questions.
2. Make sure you adapt the generated [application.conf](src/main/g8/src/main/resources/application.conf) according to your security needs.
3. To add a controller for you inhabitation requests use
    ```
    TODO
    ```
    By default they will be hosted on `http://localhost:9000/name`, where `name` will be your reply to one of the questions.
    
## Help and Contributions

Please refer to the [documentation project](https://combinators.github.io/) for a more detailed documentation.

Join [combinators/cls-scala](https://gitter.im/combinators/cls-scala) on Gitter to ask any additional questions.

### Main Authors

- Jan Bessai
- Boris Düdder
- Geroge T. Heineman

### Contributers

-
##### Your name here?
Just the usual: open pull requests and or issues.
Feel free to add yourself to the list in this file, if you contributed something.