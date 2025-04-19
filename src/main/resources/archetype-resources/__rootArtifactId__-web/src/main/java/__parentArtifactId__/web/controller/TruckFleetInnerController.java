#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.web.controller;

import ${package}.${parentArtifactId}.service.service.TruckFleetInnerService;
import ${package}.${parentArtifactId}.model.request.TruckFleetInnerRequest;
import ${package}.${parentArtifactId}.model.vo.TruckFleetInnerVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package}.base.page.BasePageVO;

/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 前端控制器
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
@RestController
@RequestMapping("/public/truckFleetInner")
@Tag(name = "车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个")
public class TruckFleetInnerController {
    @Autowired
    private TruckFleetInnerService truckFleetInnerService;


    @PostMapping("/add")
    @Operation(summary = "创建车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个")
    public Boolean create(@RequestBody TruckFleetInnerRequest request) {
        return truckFleetInnerService.create(request);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个")
    public Boolean delete(@RequestBody TruckFleetInnerRequest request) {
        return truckFleetInnerService.delete(request.getId());
    }

    @PostMapping("/update")
    @Operation(summary = "修改车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个")
    public Boolean update(@RequestBody TruckFleetInnerRequest request) {
        return truckFleetInnerService.updateById(request);
    }

    @PostMapping("/get")
    @Operation(summary = "获取车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个详情")
    public TruckFleetInnerVO getById(@RequestBody TruckFleetInnerRequest request) {
        return truckFleetInnerService.getTruckFleetInnerById(request);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个")
    public BasePageVO<TruckFleetInnerVO> page(@RequestBody TruckFleetInnerRequest request) {
        return truckFleetInnerService.page(request);
    }
}
