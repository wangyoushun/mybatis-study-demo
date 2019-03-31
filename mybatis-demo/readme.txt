




2019年3月10日
1. mybatis generator 插件的使用
   生成的时候覆盖xml， 导致自定义sql丢失
   解决方案一： 新建立一个xml 和自动生成xml同一个namespace
   方案二： 插件github上更新，解决了这个bug，
     <!--覆盖生成XML文件-->
     <plugin type="org.mybatis.generator.plugins.UnmergeableXmlMappersPlugin" />

2. 自动扫描所有mapper
   resource url class三种方式
   class只有xml和接口同一目录下使用
   不同目录下，不集成spring时未发现自动扫描的功能
