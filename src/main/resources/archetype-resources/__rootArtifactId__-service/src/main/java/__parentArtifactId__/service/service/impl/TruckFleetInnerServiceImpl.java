#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.service.service.impl;

import ${package}.${parentArtifactId}.dao.mapper.TruckFleetInnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package}.${parentArtifactId}.dao.entity.TruckFleetInner;
import ${package}.base.page.BasePageVO;
import ${package}.${parentArtifactId}.manager.service.TruckFleetInnerManagerService;
import ${package}.${parentArtifactId}.service.service.TruckFleetInnerService;
import ${package}.${parentArtifactId}.model.request.TruckFleetInnerRequest;
import ${package}.${parentArtifactId}.model.vo.TruckFleetInnerVO;
import ${package}.${parentArtifactId}.service.convert.TruckFleetInnerConvert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 服务实现类
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
@Service
public class TruckFleetInnerServiceImpl implements TruckFleetInnerService {

    @Autowired
    private TruckFleetInnerManagerService  truckFleetInnerManagerService;
    @Autowired
    private TruckFleetInnerConvert truckFleetInnerConvert;
    @Autowired
    private TruckFleetInnerMapper truckFleetInnerMapper;

     @Override
     public Boolean create(TruckFleetInnerRequest request){
         TruckFleetInner entity = truckFleetInnerConvert.toEntity(request);
         return truckFleetInnerManagerService.save(entity);
     }

     @Override
     public Boolean delete(Long id){
         TruckFleetInner entity = new TruckFleetInner();
         entity.setId(id);
         return truckFleetInnerManagerService.updateById(entity);
     }

     @Override
     public Boolean updateById(TruckFleetInnerRequest request){
         return truckFleetInnerMapper.updateByIdSelective(request);
     }

     @Override
     public TruckFleetInnerVO getTruckFleetInnerById(TruckFleetInnerRequest request){
         TruckFleetInner entity = truckFleetInnerMapper.selectBySelective(request);
         return truckFleetInnerConvert.entityToVO(entity);
     }

     @Override
     public BasePageVO<TruckFleetInnerVO> page(TruckFleetInnerRequest request){
        Page<TruckFleetInner> page = truckFleetInnerMapper.selectUsePage(new Page<>(request.getCurrentPage(), request.getPageSize()),request);

        BasePageVO<TruckFleetInnerVO> boBasePageVO = new BasePageVO<>();
        boBasePageVO.setTotalPage((int) page.getPages());
        boBasePageVO.setTotal((int) page.getTotal());
        boBasePageVO.setCurrentPage(request.getCurrentPage());
        boBasePageVO.setPageSize(request.getPageSize());

        boBasePageVO.setData(truckFleetInnerConvert.convertToList(page.getRecords()));
        return boBasePageVO;
     }
}
