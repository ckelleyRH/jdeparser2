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

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
class BasicJCommentable implements JStatement {
    private ArrayList<JComment> comments;

    protected BasicJCommentable() {
    }

    public JComment lineComment() {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        final JComment comment = new LineJComment();
        comments.add(comment);
        return comment;
    }

    public JComment blockComment() {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        final JComment comment = new BlockJComment();
        comments.add(comment);
        return comment;
    }

    public Iterable<JComment> comments() {
        return comments == null ? Collections.<JComment>emptyList() : comments;
    }
}
