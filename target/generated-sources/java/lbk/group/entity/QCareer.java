package lbk.group.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCareer is a Querydsl query type for Career
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCareer extends EntityPathBase<Career> {

    private static final long serialVersionUID = 1111933217L;

    public static final QCareer career = new QCareer("career");

    public final StringPath career_name = createString("career_name");

    public final StringPath career_title = createString("career_title");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> last_update = createDateTime("last_update", java.util.Date.class);

    public final StringPath resolution = createString("resolution");

    public final StringPath speciality = createString("speciality");

    public final BooleanPath status = createBoolean("status");

    public final StringPath username = createString("username");

    public QCareer(String variable) {
        super(Career.class, forVariable(variable));
    }

    public QCareer(Path<? extends Career> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCareer(PathMetadata metadata) {
        super(Career.class, metadata);
    }

}

