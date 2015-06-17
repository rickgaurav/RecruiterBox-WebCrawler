# RecruiterBox-WebCrawler
The repository contains the code for web crawler.

SUMMARY

1. The project is a maven project.
2. It uses Spring Dependency Injection to inject various beans.
3. The max number of links to be visited is 50.
4. If due to any reason , any link cannot be visited, the link is not counted as visited.

STEPS to build:

1. Navigate to project directory.
2. Run command "mvn clean package"
3. The above command create an executable jar for the project.
3. Then navigate to target directory.
4. Run command "java -jar webcrawler-1.0-jar-with-dependencies.jar"

