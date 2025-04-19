#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.service.convert;

import ${package}.${parentArtifactId}.dao.entity.TruckFleetInner;
import ${package}.${parentArtifactId}.model.vo.TruckFleetInnerVO;
import ${package}.${parentArtifactId}.model.request.TruckFleetInnerRequest;
import org.mapstruct.Mapper;
import java.util.List;

/**
* 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 转换器
*/
@Mapper(componentModel = "spring")
public interface TruckFleetInnerConvert {
    TruckFleetInner toEntity(TruckFleetInnerRequest request);
    TruckFleetInnerVO entityToVO(TruckFleetInner entity);
    List<TruckFleetInnerVO> convertToList(List<TruckFleetInner> list);

}
