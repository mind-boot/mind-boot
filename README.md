## mind-boot 
#### a open source project based on Spring Boot, for create a high available Spring Boot project quickly.

## create project
command template：
```
mvn archetype:generate -DarchetypeGroupId=com.mind.boot -DarchetypeArtifactId=mind-boot-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DarchetypeCatalog=local -DgroupId="被创建项目的groupId" -DartifactId="被创建项目的artifactId" -Dversion="被创建项目的版本"

args deails：
-DgroupId for groupId
-DartifactId for artifactId
-Dversion project version.

example：
mvn archetype:generate -DarchetypeGroupId=com.mind.boot -DarchetypeArtifactId=minid-boot-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DarchetypeCatalog=local -DgroupId=com.mind.boot.demo -DartifactId=demo -Dversion=1.0.0-SNAPSHOT
```