package ${package.Parent}.web.convert;

import ${package.Parent}.service.bo.${entity}BO;
import ${package.Parent}.web.vo.${entity}VO;
import ${package.Parent}.web.request.${entity}Request;
import ${package.Parent}.service.param.${entity}Param;
import ${package.Parent}.service.query.${entity}Query;
import com.ronghuiwl.base.page.BasePageBO;
import com.ronghuiwl.base.page.BasePageVO;
import org.mapstruct.Mapper;
import java.util.List;

/**
* ${table.comment!} 转换器
*/
<#if table.comment!?length gt 0>
@Mapper(componentModel = "spring")
public interface ${entity}Convert {
    // Request → Param
    ${entity}Param requestToParam(${entity}Request request);

    // Request → Query
    ${entity}Query requestToQuery(${entity}Request request);

    // BO → VO
    ${entity}VO boToVo(${entity}BO ${entity?uncap_first}BO);

    // List<BO> → List<VO>
    List<${entity}VO> boListToVoList(List<${entity}BO> ${entity?uncap_first}BOList);

    <#--// List<DO> → List<VO>-->
    <#--List<${entity}VO> doListToVoList(List<${entity}DO> ${entity?uncap_first}DOList);-->

    <#--// Page<BO> → Page<VO>-->
    BasePageVO<${entity}VO> boPageToVoPage(BasePageBO<${entity}BO> ${entity?uncap_first}BOPage);

}
</#if>