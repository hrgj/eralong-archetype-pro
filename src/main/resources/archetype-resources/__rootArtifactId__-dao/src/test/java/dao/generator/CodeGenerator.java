#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.generator;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.lang.module.Configuration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CodeGenerator {

    // 数据库配置
    private static final String JDBC_URL = "jdbc:mysql://110.42.224.57:3309/ronghuiwl?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "ronghuiwl2025";

    // 项目配置
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String PARENT_PACKAGE = "${package}.${parentArtifactId}";

    // 表配置
    private static final String[] TABLE_NAMES = {"upload_records"}; // 要生成的表
//    private static final String[] TABLE_PREFIXES = {"t_", "sys_"}; // 表前缀过滤

    public static void main(String[] args) {
        generateModel();
        generateDao();    // 生成DAO层代码
        generateManagerService(); // 生成Service层代码
        generateService(); // 生成Service层代码
        generateWeb();     // 生成Web层代码
    }

    private static void generateDao() {
        FastAutoGenerator.create(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("system")
                            .outputDir(PROJECT_PATH + "/${artifactId}/src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE)
                            .moduleName("")
                            .entity("dao.entity")
                            .mapper("dao.mapper")
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    PROJECT_PATH + "/${artifactId}/src/main/resources/mapper"
                            ));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES)
//                            .addTablePrefix(TABLE_PREFIXES)
                            .entityBuilder()
                            .javaTemplate("/templates/entity.java")
                            .enableLombok()
                            .enableChainModel()
                            .enableFileOverride()
                            .mapperBuilder()
                            .formatMapperFileName("%sMapper")
                            .mapperTemplate("/templates/mapper.java")
                            .enableFileOverride()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .enableBaseColumnList()
                            .mapperXmlTemplate("/templates/mapper.xml")
                            .serviceBuilder().disable()
                            .controllerBuilder().disable()
                    ;
//                }).injectionConfig(builder -> {
//                    Map<String,Object> customMap = new HashMap<>();
////                    customMap.put("abc","1234");
//                    builder.customMap(customMap); //注入自定义属性
//                    builder.customFile(new CustomFile.Builder()
//                            .fileName("DO.java") //文件名称
//                            .templatePath("/templates/entityDO.java.ftl") //指定生成模板路径
//                                    .enableFileOverride()
//                            .packageName("domain") //包名,自3.5.10开始,可通过在package里面获取自定义包全路径,低版本下无法获取,示例:package.entityDTO
//                            .build())
//                            .customFile(new CustomFile.Builder()
//                                    .fileName("DaoQuery.java") //文件名称
//                                    .templatePath("/templates/DaoQuery.java.ftl") //指定生成模板路径
//                                    .enableFileOverride()
//                                    .packageName("query") //包名,自3.5.10开始,可通过在package里面获取自定义包全路径,低版本下无法获取,示例:package.entityDTO
//                                    .build());
//                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private static void generateManagerService() {
        FastAutoGenerator.create(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("system")
                            .outputDir(PROJECT_PATH + "/${parentArtifactId}-manager/src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE)
                            .moduleName("")
                            .service("manager.service")
                            .serviceImpl("manager.service.impl");
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES)
//                            .addTablePrefix(TABLE_PREFIXES)
                            .entityBuilder().disable()
                            .mapperBuilder().disable()
                            .controllerBuilder().disable()
                            .serviceBuilder()
                            .formatServiceFileName("%sManagerService")
                            .formatServiceImplFileName("%sManagerServiceImpl")
                            .enableFileOverride()
                            .serviceTemplate("/templates/managerService.java")
                            .serviceImplTemplate("/templates/managerServiceImpl.java")
                            .enableFileOverride()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private static void generateService() {
        FastAutoGenerator.create(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("system")
                            .outputDir(PROJECT_PATH + "/${parentArtifactId}-service/src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE)
                            .moduleName("")
                            .service("service.service")
                            .serviceImpl("service.service.impl");
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES)
//                            .addTablePrefix(TABLE_PREFIXES)
                            .entityBuilder()
                            .disable()
                            .mapperBuilder()
                            .formatMapperFileName("%sMapper")
                            .disable()
                            .controllerBuilder().disable()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .serviceTemplate("/templates/service.java")
                            .serviceImplTemplate("/templates/serviceImpl.java")
                            .enableFileOverride()
                    ;
                }).injectionConfig(builder -> {
                    Map<String,Object> customMap = new HashMap<>();
//                    customMap.put("abc","1234");
                    builder.customMap(customMap); //注入自定义属性
//                    builder.customFile(new CustomFile.Builder()
//                            .fileName("BO.java") //文件名称
//                            .templatePath("/templates/entityBO.java.ftl") //指定生成模板路径
//                            .enableFileOverride()
//                            .packageName("service.bo") //包名,自3.5.10开始,可通过在package里面获取自定义包全路径,低版本下无法获取,示例:package.entityDTO
//                            .build())
//                            .customFile(new CustomFile.Builder()
//                                    .fileName("Param.java")
//                                    .templatePath("/templates/entityParam.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("service.param")
//                                    .build()
//                            ).customFile(new CustomFile.Builder()
//                                    .fileName("Query.java")
//                                    .templatePath("/templates/entityQuery.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("service.query")
//                                    .build()
                    builder.customFile(new CustomFile.Builder()
                                    .fileName("Convert.java")
                                    .templatePath("/templates/serviceConvert.java.ftl")
                                    .enableFileOverride()
                                    .packageName("service.convert")
                                    .build()
                            )
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private static void generateWeb() {
        FastAutoGenerator.create(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("system")
                            .outputDir(PROJECT_PATH + "/${parentArtifactId}-web/src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE)
                            .moduleName("")
                            .controller("web.controller")
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES)
//                            .addTablePrefix(TABLE_PREFIXES)
                            .entityBuilder().disable()
                            .mapperBuilder().disable()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .disable()
                            .controllerBuilder()
                            .enableRestStyle()
                            .enableFileOverride()
                            .formatFileName("%sController")
                            .template("/templates/controller.java")
                            .enableHyphenStyle();
//                }).injectionConfig(builder -> {
//                    Map<String,Object> customMap = new HashMap<>();
////                    customMap.put("abc","1234");
//                    builder.customMap(customMap); //注入自定义属性
//                    builder.customFile(new CustomFile.Builder()
//                                    .fileName("VO.java") //文件名称
//                                    .templatePath("/templates/entityVO.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("web.vo") //包名,自3.5.10开始,可通过在package里面获取自定义包全路径,低版本下无法获取,示例:package.entityDTO
//                                    .build())
//                            .customFile(new CustomFile.Builder()
//                                    .fileName("Request.java")
//                                    .templatePath("/templates/entityRequest.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("web.request")
//                                    .build()
//                            ).customFile(new CustomFile.Builder()
//                                    .fileName("Convert.java")
//                                    .templatePath("/templates/webConvert.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("web.convert")
//                                    .build()
//                            )
//                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private static void generateModel() {
        FastAutoGenerator.create(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("system")
                            .outputDir(PROJECT_PATH + "/${parentArtifactId}-model/src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE)
                            .moduleName("model")
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES)
//                            .addTablePrefix(TABLE_PREFIXES)
                            .entityBuilder().disable()
                            .mapperBuilder().disable()
                            .serviceBuilder().disable()
                            .controllerBuilder().disable();

                }).injectionConfig(builder -> {
                    Map<String,Object> customMap = new HashMap<>();
//                    customMap.put("abc","1234");
                    builder.customMap(customMap); //注入自定义属性
                    builder.customFile(new CustomFile.Builder()
                                    .fileName("VO.java") //文件名称
                                    .templatePath("/templates/entityVO.java.ftl")
                                    .enableFileOverride()
                                    .packageName("vo") //包名,自3.5.10开始,可通过在package里面获取自定义包全路径,低版本下无法获取,示例:package.entityDTO
                                    .build())
                            .customFile(new CustomFile.Builder()
                                    .fileName("Request.java")
                                    .templatePath("/templates/entityRequest.java.ftl")
                                    .enableFileOverride()
                                    .packageName("request")
                                    .build()
//                            ).customFile(new CustomFile.Builder()
//                                    .fileName("Convert.java")
//                                    .templatePath("/templates/webConvert.java.ftl")
//                                    .enableFileOverride()
//                                    .packageName("convert")
//                                    .build()
                            )
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}