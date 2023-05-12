set projectLocation=E:/eclipse-workspace/AutomationPractice
cd %projectLocation%
mvn test -Dcucumber.options="E:/eclipse-workspace/AutomationPractice/src/test/resources/FeatureCollections"