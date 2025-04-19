package ${package.Parent}.service.convert;

import ${package.Parent}.dao.entity.${entity};
import ${package.Parent}.model.vo.${entity}VO;
import ${package.Parent}.model.request.${entity}Request;
import org.mapstruct.Mapper;
import java.util.List;

/**
* ${table.comment!} 转换器
*/
<#if table.comment!?length gt 0>
@Mapper(componentModel = "spring")
public interface ${entity}Convert {
    ${entity} toEntity(${entity}Request request);
    ${entity}VO entityToVO(${entity} entity);
    List<${entity}VO> convertToList(List<${entity}> list);

}
</#if>