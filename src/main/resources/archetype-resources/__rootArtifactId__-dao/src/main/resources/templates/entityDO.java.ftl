package ${package.Parent}.domain;

<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#if swagger>
import io.swagger.v3.oas.annotations.media.Schema;
</#if>
<#if entityLombokModel>
import lombok.Data;
<#--    import lombok.EqualsAndHashCode;-->
<#--    import lombok.experimental.Accessors;-->
</#if>

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if entityLombokModel>
@Data
<#--    <#if superEntityClass??>-->
<#--        @EqualsAndHashCode(callSuper = true)-->
<#--    <#else>-->
<#--        @EqualsAndHashCode(callSuper = false)-->
<#--    </#if>-->
<#--    @Accessors(chain = true)-->
</#if>
<#--<#if table.convert>-->
<#--    @TableName("${table.name}")-->
<#--</#if>-->
<#if swagger>
@Schema(name = "${entity}DO", description = "${table.comment!}")
</#if>
<#if superEntityClass??>
public class ${entity}DO extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity}DO extends Model
<${entity}DO> {
<#else>
public class ${entity}DO implements Serializable {
</#if>

<#--private static final long serialVersionUID = 1L;-->
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
    <#if swagger>
    @Schema(description = "${field.comment}")
    <#else>
    /**
    * ${field.comment}
    */
    </#if>
    </#if>
    <#if field.keyFlag>
    <#-- 主键 -->
<#--        <#if field.keyIdentityFlag>-->
<#--            @TableId(value = "${field.name}", type = IdType.AUTO)-->
<#--        <#elseif idType??>-->
<#--            @TableId(value = "${field.name}", type = IdType.${idType})-->
<#--        <#elseif field.convert>-->
<#--            @TableId("${field.name}")-->
<#--        </#if>-->
    <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
    <#if field.convert>
        @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
    <#else>
        @TableField(fill = FieldFill.${field.fill})
    </#if>
    <#elseif field.convert>
        @TableField("${field.name}")
    </#if>
<#-- 乐观锁注解 -->
    <#if (versionFieldName!"") == field.name>
        @Version
    </#if>
<#-- 逻辑删除注解 -->
    <#if (logicDeleteFieldName!"") == field.name>
        @TableLogic
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>
        public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
        }

        <#if entityBuilderModel>
            public ${entity}DO set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        <#else>
            public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if entityBuilderModel>
            return this;
        </#if>
        }
    </#list>
</#if>

<#if activeRecord>
    @Override
    protected Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }
</#if>

<#if !entityLombokModel>
    @Override
    public String toString() {
    return "${entity}DO{" +
    <#list table.fields as field>
        <#if field_index==0>
            "${field.propertyName}=" + ${field.propertyName} +
        <#else>
            ", ${field.propertyName}=" + ${field.propertyName} +
        </#if>
    </#list>
    "}";
    }
</#if>
}