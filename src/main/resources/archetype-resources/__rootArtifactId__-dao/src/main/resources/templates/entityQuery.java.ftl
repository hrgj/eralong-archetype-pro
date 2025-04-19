package ${package.Parent}.service.query;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
* ${table.comment!} 查询参数
*/
@Data
@Accessors(chain = true)
public class ${entity}Query implements Serializable {

<#list table.fields as field>
    <#if field.comment!?length gt 0>
    <#if entityFieldUseJavaDoc>
    /**
    * ${field.comment}
    */
    </#if>
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
}