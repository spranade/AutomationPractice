set projectLocation=D:/eclipse-workspace/AutomationPractice
cd %projectLocation%
mvn test -Dcucumber.options="D:/eclipse-workspace/AutomationPractice/src/test/resources/FeatureCollections"