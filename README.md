## mind-boot 
#### a open source project based on Spring Boot, for create a high available Spring Boot project quickly.

## create project
command template：
```
mvn archetype:generate -DarchetypeGroupId=io.github.mind-boot -DarchetypeArtifactId=mind-boot-archetype -DarchetypeVersion=1.0.0-RELEASE -DarchetypeCatalog=local -DgroupId="被创建项目的groupId" -DartifactId="被创建项目的artifactId" -Dversion="被创建项目的版本"

args deails：
-DgroupId for groupId
-DartifactId for artifactId
-Dversion project version.

example：
mvn archetype:generate -DarchetypeGroupId=io.github.mind-boot -DarchetypeArtifactId=minid-boot-archetype -DarchetypeVersion=1.0.0-RELEASE -DarchetypeCatalog=local -DgroupId=io.github.mind.boot.demo -DartifactId=demo -Dversion=1.0.0-RELEASE
```