package ${package.Service};

import com.ronghuiwl.base.page.BasePageVO;
import ${package.Parent}.model.vo.${entity}VO;
import ${package.Parent}.model.request.${entity}Request;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName}  {
    Boolean create(${entity}Request request);
    Boolean delete(Long id);
    Boolean updateById(${entity}Request request);
    ${entity}VO get${entity}ById(${entity}Request request);
    BasePageVO<${entity}VO> page(${entity}Request request);
}
</#if>
