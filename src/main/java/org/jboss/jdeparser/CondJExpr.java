/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.jdeparser;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
class CondJExpr extends AbstractJExpr {

    private final AbstractJExpr cond;
    private final AbstractJExpr ifTrue;
    private final AbstractJExpr ifFalse;

    CondJExpr(final AbstractJExpr cond, final AbstractJExpr ifTrue, final AbstractJExpr ifFalse) {
        super(Prec.COND);
        this.cond = cond.prec() < Prec.COND ? new ParenJExpr(cond) : cond;
        this.ifTrue = ifTrue.prec() < Prec.COND ? new ParenJExpr(ifTrue) : ifTrue;
        this.ifFalse = ifFalse.prec() < Prec.COND ? new ParenJExpr(ifFalse) : ifFalse;
    }

    AbstractJExpr getCond() {
        return cond;
    }

    AbstractJExpr getIfTrue() {
        return ifTrue;
    }

    AbstractJExpr getIfFalse() {
        return ifFalse;
    }
}
