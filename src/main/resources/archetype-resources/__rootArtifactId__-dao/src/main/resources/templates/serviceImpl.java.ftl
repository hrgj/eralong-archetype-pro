package ${package.ServiceImpl};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package.Parent}.dao.entity.${entity};
import com.ronghuiwl.base.page.BasePageVO;
import ${package.Parent}.manager.service.${entity}ManagerService;
import ${package.Parent}.service.service.${entity}Service;
import ${package.Parent}.model.request.${entity}Request;
import ${package.Parent}.model.vo.${entity}VO;
import ${package.Parent}.service.convert.${entity}Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Autowired
    private ${entity}ManagerService  ${table.entityPath}ManagerService;
    @Autowired
    private ${entity}Convert ${table.entityPath}Convert;
    @Autowired
    private ${entity}Mapper ${table.entityPath}Mapper;

     @Override
     public Boolean create(${entity}Request request){
         ${entity} entity = ${table.entityPath}Convert.toEntity(request);
         return ${table.entityPath}ManagerService.save(entity);
     }

     @Override
     public Boolean delete(Long id){
         ${entity} entity = new ${entity}();
         entity.setId(id);
         return ${table.entityPath}ManagerService.updateById(entity);
     }

     @Override
     public Boolean updateById(${entity}Request request){
         return ${table.entityPath}Mapper.updateByIdSelective(request);
     }

     @Override
     public ${entity}VO get${entity}ById(${entity}Request request){
         ${entity} entity = ${table.entityPath}Mapper.selectBySelective(request);
         return ${table.entityPath}Convert.entityToVO(entity);
     }

     @Override
     public BasePageVO<${entity}VO> page(${entity}Request request){
        Page<${entity}> page = ${table.entityPath}Mapper.selectUsePage(new Page<>(request.getCurrentPage(), request.getPageSize()),request);

        BasePageVO<${entity}VO> boBasePageVO = new BasePageVO<>();
        boBasePageVO.setTotalPage((int) page.getPages());
        boBasePageVO.setTotal((int) page.getTotal());
        boBasePageVO.setCurrentPage(request.getCurrentPage());
        boBasePageVO.setPageSize(request.getPageSize());

        boBasePageVO.setData(${table.entityPath}Convert.convertToList(page.getRecords()));
        return boBasePageVO;
     }
}
</#if>
