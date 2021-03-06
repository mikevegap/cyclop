/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cyclop.model;

import net.jcip.annotations.Immutable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * cql keywords are: create keyspace, use, alter keyspace, drop keyspace, create
 * table, alter table, drop table, truncate, create index, drop index, insert,
 * update, delete, batch, select
 *
 * @author Maciej Miklas
 */
@Immutable
public class CqlKeyword extends CqlPart {

	@NotEmpty
	public final String valueSp;

	public static enum Def {
		FROM("from"), DELETE("delete"), DROP_INDEX("drop index"), INSERT_INTO("insert into"), INSERT("insert"), UPDATE(
				"update"), TRUNCATE("truncate"), WHERE("where"), USING_TIMESTAMP("using timestamp"), USING_TTL(
				"using ttl"), ORDER_BY("order by"), ASC("asc"), DESC("desc"), WITH("with"), LIMIT("limit"), ALLOW_FILTERING(
				"allow filtering"), TOKEN("token"), IN("in"), AND("and"), IN_BL("in ("), DROP_TABLE("drop table"), VALUES(
				"values"), SELECT("select"), COUNT_AST("count (*)"), COUNT_ONE("count (1)"), WRITETIME("writetime"), TTL(
				"ttl"), SET("set"), USE("use"), DROP_KEYSPACE("drop keyspace"), CREATE_KEYSPACE("create keyspace"), REPLICATION(
				"replication"), IF_NOT_EXISTS("if not exists"), IF_EXISTS("if exists");

		private Def(String value) {
			this.value = new CqlKeyword(value.toLowerCase());
		}

		public CqlKeyword value;
	}

	protected CqlKeyword(String val) {
		super(val);
		this.valueSp = val.toLowerCase() + " ";
	}

	@Override
	public String toString() {
		return "CqlKeyword{" + "part='" + part + '\'' + '}';
	}

	@Override
	public CqlType type() {
		return CqlType.KEYWORD;
	}

	@edu.umd.cs.findbugs.annotations.SuppressWarnings("EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS")
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CqlPart cqlObj = (CqlPart) obj;
		return partLc.equals(cqlObj.partLc);
	}

	@Override
	public int hashCode() {
		return partLc.hashCode();
	}
}
