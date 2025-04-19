#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.service.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import ${package}.base.common.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 用途：全局createUserName，createUserCode，modifyUserName，modifyUserCode自动填充，
 * 如何使用：在需要自动填充的字段上添加注解@TableField(fill = FieldFill.INSERT)用于填充插入操作或@TableField(fill = FieldFill.UPDATE)用于填充更新操作
 */
@Slf4j
@Component
public class OperatorMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createUserName", String.class, UserContext.getCurrentUser().getUserName());
        this.strictInsertFill(metaObject, "createUserCode", String.class, UserContext.getCurrentUser().getUserCode());
        this.strictInsertFill(metaObject, "createSiteName", String.class, UserContext.getCurrentUser().getSiteName());
        this.strictInsertFill(metaObject, "createSiteCode", String.class, UserContext.getCurrentUser().getSiteCode());
        this.strictInsertFill(metaObject, "modifyTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modifyUserName", String.class, UserContext.getCurrentUser().getUserName());
        this.strictInsertFill(metaObject, "modifyUserCode", String.class, UserContext.getCurrentUser().getUserCode());
        this.strictInsertFill(metaObject, "modifySiteName", String.class, UserContext.getCurrentUser().getSiteName());
        this.strictInsertFill(metaObject, "modifySiteCode", String.class, UserContext.getCurrentUser().getSiteCode());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "modifyTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "modifyUserName", String.class, UserContext.getCurrentUser().getUserName());
        this.strictUpdateFill(metaObject, "modifyUserCode", String.class, UserContext.getCurrentUser().getUserCode());
        this.strictUpdateFill(metaObject, "modifySiteName", String.class, UserContext.getCurrentUser().getSiteName());
        this.strictUpdateFill(metaObject, "modifySiteCode", String.class, UserContext.getCurrentUser().getSiteCode());
    }
}
