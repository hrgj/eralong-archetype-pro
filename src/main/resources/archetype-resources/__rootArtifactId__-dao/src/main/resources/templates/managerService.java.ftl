package ${package.Service};

import ${package.Parent}.dao.entity.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} manager服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
