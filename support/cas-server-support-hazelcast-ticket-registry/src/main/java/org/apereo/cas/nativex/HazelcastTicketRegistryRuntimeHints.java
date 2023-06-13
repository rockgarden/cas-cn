package org.apereo.cas.nativex;

import org.apereo.cas.util.function.FunctionUtils;
import org.apereo.cas.util.nativex.CasRuntimeHintsRegistrar;
import com.hazelcast.logging.LoggerFactory;
import com.hazelcast.shaded.org.apache.calcite.DataContext;
import com.hazelcast.shaded.org.apache.calcite.adapter.enumerable.AggregateLambdaFactory;
import com.hazelcast.shaded.org.apache.calcite.adapter.enumerable.EnumUtils;
import com.hazelcast.shaded.org.apache.calcite.adapter.enumerable.LazyAggregateLambdaFactory;
import com.hazelcast.shaded.org.apache.calcite.adapter.enumerable.MatchUtils;
import com.hazelcast.shaded.org.apache.calcite.adapter.enumerable.SourceSorter;
import com.hazelcast.shaded.org.apache.calcite.avatica.util.DateTimeUtils;
import com.hazelcast.shaded.org.apache.calcite.interpreter.Context;
import com.hazelcast.shaded.org.apache.calcite.interpreter.Node;
import com.hazelcast.shaded.org.apache.calcite.interpreter.Row;
import com.hazelcast.shaded.org.apache.calcite.interpreter.Scalar;
import com.hazelcast.shaded.org.apache.calcite.linq4j.Enumerable;
import com.hazelcast.shaded.org.apache.calcite.linq4j.EnumerableDefaults;
import com.hazelcast.shaded.org.apache.calcite.linq4j.Enumerator;
import com.hazelcast.shaded.org.apache.calcite.linq4j.Linq4j;
import com.hazelcast.shaded.org.apache.calcite.linq4j.Lookup;
import com.hazelcast.shaded.org.apache.calcite.linq4j.MemoryFactory;
import com.hazelcast.shaded.org.apache.calcite.linq4j.QueryProvider;
import com.hazelcast.shaded.org.apache.calcite.linq4j.Queryable;
import com.hazelcast.shaded.org.apache.calcite.linq4j.function.Function;
import com.hazelcast.shaded.org.apache.calcite.linq4j.function.Functions;
import com.hazelcast.shaded.org.apache.calcite.linq4j.tree.FunctionExpression;
import com.hazelcast.shaded.org.apache.calcite.rel.RelNode;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.BuiltInMetadata;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.Metadata;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.MetadataDef;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.MetadataHandler;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.RelMetadataProvider;
import com.hazelcast.shaded.org.apache.calcite.rel.metadata.UnboundMetadata;
import com.hazelcast.shaded.org.apache.calcite.runtime.BinarySearch;
import com.hazelcast.shaded.org.apache.calcite.runtime.Bindable;
import com.hazelcast.shaded.org.apache.calcite.runtime.CompressionFunctions;
import com.hazelcast.shaded.org.apache.calcite.runtime.Enumerables;
import com.hazelcast.shaded.org.apache.calcite.runtime.FlatLists;
import com.hazelcast.shaded.org.apache.calcite.runtime.FunctionContexts;
import com.hazelcast.shaded.org.apache.calcite.runtime.JsonFunctions;
import com.hazelcast.shaded.org.apache.calcite.runtime.Matcher;
import com.hazelcast.shaded.org.apache.calcite.runtime.Pattern;
import com.hazelcast.shaded.org.apache.calcite.runtime.RandomFunction;
import com.hazelcast.shaded.org.apache.calcite.runtime.SortedMultiMap;
import com.hazelcast.shaded.org.apache.calcite.runtime.SpatialTypeFunctions;
import com.hazelcast.shaded.org.apache.calcite.runtime.SqlFunctions;
import com.hazelcast.shaded.org.apache.calcite.runtime.Utilities;
import com.hazelcast.shaded.org.apache.calcite.runtime.XmlFunctions;
import com.hazelcast.shaded.org.apache.calcite.schema.FunctionContext;
import com.hazelcast.shaded.org.apache.calcite.schema.Member;
import com.hazelcast.shaded.org.apache.calcite.schema.ModifiableTable;
import com.hazelcast.shaded.org.apache.calcite.schema.ModifiableView;
import com.hazelcast.shaded.org.apache.calcite.schema.Schema;
import com.hazelcast.shaded.org.apache.calcite.schema.SchemaPlus;
import com.hazelcast.shaded.org.apache.calcite.schema.Schemas;
import com.hazelcast.shaded.org.apache.calcite.schema.Statistic;
import com.hazelcast.shaded.org.apache.calcite.schema.Table;
import com.hazelcast.sql.SqlService;
import com.hazelcast.sql.impl.type.converter.Converter;
import lombok.val;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import java.util.Collection;
import java.util.List;

/**
 * This is {@link HazelcastTicketRegistryRuntimeHints}.
 *
 * @author Misagh Moayyed
 * @since 7.0.0
 */
public class HazelcastTicketRegistryRuntimeHints implements CasRuntimeHintsRegistrar {
    @Override
    public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
        registerReflectionHints(hints,
            List.of(
                Schemas.class,
                SchemaPlus.class,
                Queryable.class,
                SortedMultiMap.class,
                Lookup.class,
                Row.class,
                Pattern.class,
                Matcher.class,
                Matcher.Builder.class,
                MatchUtils.class,
                DateTimeUtils.class,
                Utilities.class,
                BinarySearch.class,
                Enumerables.class,
                Enumerables.Emitter.class,
                QueryProvider.class,
                DataContext.class,
                FunctionExpression.class,
                SpatialTypeFunctions.class,
                CompressionFunctions.class,
                Functions.class,
                RandomFunction.class,
                SqlFunctions.class,
                JsonFunctions.class,
                XmlFunctions.class,
                Enumerator.class,
                EnumerableDefaults.class,
                Member.class,
                Linq4j.class,
                Statistic.class,
                FlatLists.class,
                Scalar.class,
                Context.class,
                Node.class,
                SourceSorter.class,
                DataContext.class,
                FunctionContext.class,
                FunctionContexts.class,
                MemoryFactory.class,
                MemoryFactory.Memory.class,
                BuiltInMetadata.class,
                Pattern.PatternBuilder.class,
                AggregateLambdaFactory.class,
                LazyAggregateLambdaFactory.LazyAccumulator.class,
                EnumUtils.class,
                UnboundMetadata.class,
                MetadataDef.class
            )
        );
        var classes = findSubclassesInPackage(Converter.class, "com.hazelcast.sql");
        registerReflectionHints(hints, classes);
        registerSerializationHints(hints, classes);

        registerReflectionHints(hints,
            findSubclassesInPackage(Function.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(ModifiableView.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(ModifiableTable.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Table.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Bindable.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Schema.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Enumerable.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(AggregateLambdaFactory.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(LazyAggregateLambdaFactory.LazyAccumulator.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Metadata.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(MetadataHandler.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(SqlService.class, "com.hazelcast.sql"));
        registerReflectionHints(hints,
            findSubclassesInPackage(LoggerFactory.class, "com.hazelcast.logging"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Pattern.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(Queryable.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(RelMetadataProvider.class, "com.hazelcast.shaded.org.apache.calcite"));
        registerReflectionHints(hints,
            findSubclassesInPackage(RelNode.class, "com.hazelcast.shaded.org.apache.calcite"));

        FunctionUtils.doAndHandle(__ -> {
            var clazz = ClassUtils.getClass("com.hazelcast.shaded.org.jctools.queues.ConcurrentCircularArrayQueueL0Pad", false);
            registerReflectionHints(hints,
                findSubclassesInPackage(clazz, "com.hazelcast.shaded.org.jctools"));
        });
    }

    private static void registerSerializationHints(final RuntimeHints hints, final Collection<Class> entries) {
        entries.forEach(el -> hints.serialization().registerType(el));
    }

    private static void registerReflectionHints(final RuntimeHints hints, final Collection entries) {
        val memberCategories = new MemberCategory[]{
            MemberCategory.INTROSPECT_DECLARED_CONSTRUCTORS,
            MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS,
            MemberCategory.INTROSPECT_DECLARED_METHODS,
            MemberCategory.INTROSPECT_PUBLIC_METHODS,
            MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
            MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
            MemberCategory.INVOKE_DECLARED_METHODS,
            MemberCategory.INVOKE_PUBLIC_METHODS,
            MemberCategory.DECLARED_FIELDS,
            MemberCategory.PUBLIC_FIELDS};
        entries.forEach(el -> hints.reflection().registerType((Class) el, memberCategories));
    }
}