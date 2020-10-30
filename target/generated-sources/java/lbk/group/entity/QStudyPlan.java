package lbk.group.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudyPlan is a Querydsl query type for StudyPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudyPlan extends EntityPathBase<StudyPlan> {

    private static final long serialVersionUID = 1070317583L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudyPlan studyPlan = new QStudyPlan("studyPlan");

    public final QCareer career;

    public final StringPath duration = createString("duration");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final NumberPath<Integer> quantityMaterials = createNumber("quantityMaterials", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final BooleanPath status = createBoolean("status");

    public final StringPath studyPlanName = createString("studyPlanName");

    public final StringPath username = createString("username");

    public QStudyPlan(String variable) {
        this(StudyPlan.class, forVariable(variable), INITS);
    }

    public QStudyPlan(Path<? extends StudyPlan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudyPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudyPlan(PathMetadata metadata, PathInits inits) {
        this(StudyPlan.class, metadata, inits);
    }

    public QStudyPlan(Class<? extends StudyPlan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.career = inits.isInitialized("career") ? new QCareer(forProperty("career")) : null;
    }

}

