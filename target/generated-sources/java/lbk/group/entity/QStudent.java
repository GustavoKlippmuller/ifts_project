package lbk.group.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1972043000L;

    public static final QStudent student = new QStudent("student");

    public final StringPath celphone = createString("celphone");

    public final StringPath documentNumber = createString("documentNumber");

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> last_update = createDateTime("last_update", java.util.Date.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath telephone = createString("telephone");

    public final StringPath typeDocument = createString("typeDocument");

    public final StringPath username = createString("username");

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

