package ${package.Mapper};

<#list importMapperFrameworkPackages as pkg>
import ${pkg};
</#list>
<#if importMapperJavaPackages?size !=0>

  <#list importMapperJavaPackages as pkg>
import ${pkg};
   </#list>
</#if>
import ${package.Parent}.model.request.${entity}Request;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}> {
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
</#if>

<#list mapperMethodList as m>
    /**
     * generate by ${m.indexName}
     *
    <#list m.tableFieldList as f>
     * @param ${f.propertyName} ${f.comment}
    </#list>
     */
    ${m.method}
</#list>
    Boolean updateByIdSelective(${entity}Request request);
    ${entity} selectBySelective(${entity}Request request);
    Page<${entity}> selectUsePage(@Param("page") Page<${entity}Request> page, @Param("request") ${entity}Request request);
}

