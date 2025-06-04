# selenide-grid
A sample project showing how to run Selenide tests with Selenium Grid

## How to run tests on Linux, Windows and Mac Intel:

> docker compose up -d
> ./gradlew test
> docker compose down

## How to run tests on Mac ARM (M1...M4 processors):

> docker compose -f docker-compose.arm.yml up -d
> ./gradlew test
> docker compose down

### Explanation
1. The first line starts Selenium Grid in docker
2. The second line runs the tests
3. The third line stops the Selenium Grid
