package ${package.ServiceImpl};

import ${package.Parent}.dao.entity.${entity};
import ${package.Parent}.dao.mapper.${table.mapperName};
<#if generateService>
import ${package.Parent}.manager.service.${table.serviceName};
</#if>
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>()<#if generateService>, ${table.serviceName}</#if> {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}><#if generateService> implements ${table.serviceName}</#if> {

}
</#if>
