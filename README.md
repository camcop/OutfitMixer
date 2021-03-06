# OutfitMixer

OutfitMixer provides a REST API to allow a user to interact with a database containing items of clothing. Data fields comprise name, type, brand, and colour.

The application is written in Java and built on Spring Boot, using Maven for dependency management, mySQL as a primary database and H2 for testing.

Coverage: 96%

[Link to project jira board](https://camcop.atlassian.net/jira/software/projects/OUT/boards/2/roadmap)

### Potential future features

* A front-end with a displayed image of each item of clothing
* The ability to randomly select items and generate outfits 
* User accounts, authentication and security, and the ability to save wardrobes
* Integration with third-party e-commerce websites to allow for the selection of outfits from a much larger range
* AI-generated item recommendations to complement existing wardrobe contents

## Getting Started

To run the application java must be installed. Run the .jar file using the following command:

```java -jar OutfitMixer-1.0.0.jar```



## ERD diagram

![img.png](screenshots/ERD-diagram.png)

## Test coverage

![img.png](screenshots/test-coverage.png)

## Postman screenshots
### Create

![img_1.png](screenshots/Postman-create.png)

### Read all
![img.png](screenshots/Postman-readall.png)
### Read one
![img.png](screenshots/Postman-readone.png)
### Update
![img.png](screenshots/Postman-update.png)
### Delete
![img.png](screenshots/Postman-delete.png)
## MySQL screenshot
![img.png](screenshots/MySQL.png)