package lbk.group.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1637462574L;

    public static final QUser user = new QUser("user");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath first_name = createString("first_name");

    public final StringPath last_name = createString("last_name");

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public final SetPath<UserRole, QUserRole> userRole = this.<UserRole, QUserRole>createSet("userRole", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}
