package com.sksamuel.elastic4s.http.search.queries.span

import com.sksamuel.elastic4s.http.search.queries.QueryBuilderFn
import com.sksamuel.elastic4s.searches.queries.span.{SpanMultiTermQueryDefinition, SpanWithinQueryDefinition}
import org.elasticsearch.common.xcontent.{XContentBuilder, XContentFactory}

object SpanMultiTermQueryBodyFn {
  def apply(q: SpanMultiTermQueryDefinition): XContentBuilder = {
    val builder = XContentFactory.jsonBuilder()
    builder.startObject()
    builder.rawField("span_multi", QueryBuilderFn(q.query).bytes)
    q.boost.foreach(builder.field("boost", _))
    q.queryName.foreach(builder.field("_name", _))
    builder.endObject()
  }
}
