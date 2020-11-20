package lbk.group.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudyPlan is a Querydsl query type for StudyPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudyPlan extends EntityPathBase<StudyPlan> {

    private static final long serialVersionUID = 1070317583L;

    public static final QStudyPlan studyPlan = new QStudyPlan("studyPlan");

    public final StringPath duration = createString("duration");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idCareer = createNumber("idCareer", Integer.class);

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final NumberPath<Integer> quantityMaterials = createNumber("quantityMaterials", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final BooleanPath status = createBoolean("status");

    public final StringPath studyPlanName = createString("studyPlanName");

    public final StringPath username = createString("username");

    public QStudyPlan(String variable) {
        super(StudyPlan.class, forVariable(variable));
    }

    public QStudyPlan(Path<? extends StudyPlan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudyPlan(PathMetadata metadata) {
        super(StudyPlan.class, metadata);
    }

}

