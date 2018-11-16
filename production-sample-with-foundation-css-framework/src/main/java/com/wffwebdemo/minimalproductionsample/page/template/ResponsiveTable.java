package com.wffwebdemo.minimalproductionsample.page.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.webfirmframework.wffweb.tag.html.AbstractHtml;
import com.webfirmframework.wffweb.tag.html.attribute.global.ClassAttribute;
import com.webfirmframework.wffweb.tag.html.html5.attribute.global.DataAttribute;
import com.webfirmframework.wffweb.tag.html.tables.TBody;
import com.webfirmframework.wffweb.tag.html.tables.THead;
import com.webfirmframework.wffweb.tag.html.tables.Table;
import com.webfirmframework.wffweb.tag.html.tables.Td;
import com.webfirmframework.wffweb.tag.html.tables.Th;
import com.webfirmframework.wffweb.tag.html.tables.Tr;
import com.webfirmframework.wffweb.tag.htmlwff.NoTag;

/**
 * assets/css/app.css contains css for this table
 *
 */
@SuppressWarnings("serial")
public class ResponsiveTable extends Table {

    public ResponsiveTable(AbstractHtml base) {
        super(base, new ClassAttribute("responsive-card-table unstriped"));

        develop();
    }

    // @formatter:off
    private void develop() {
        
        List<String> headNames = Arrays.asList("First Name", "Last Name", "Hero Title");
        
       
        Collection<Collection<String>> rows = new ArrayList<>();
        rows.add(Arrays.asList("Bruce", "Wayne", "Batman"));
        rows.add(Arrays.asList("Peter", "Parker", "Spiderman"));
        rows.add(Arrays.asList("Bruce", "Banner", "The Hulk"));
        rows.add(Arrays.asList("Clark", "Kent", "Superman"));
        
        

        new THead(this) {{
            new Tr(this) {{
                for (String headName : headNames) {
                    new Th(this) {{
                        new NoTag(this, headName);
                    }};    
                }               
            }};
        }};
        new TBody(this) {{
            for (Collection<String> row : rows) {
                developTr(this, row, headNames);
            }
        }};    
        
    }
    
    private void developTr(TBody tBody, Collection<String> row, List<String> headNames) {
        Tr tr = new Tr(this) {{
            int i = 0;
            for (String cellValue : row) {
                new Td(this,
                        new DataAttribute("label", headNames.get(i))) {{
                    new NoTag(this, cellValue);
                }};
                i++;
            }
            
        }};
        tBody.appendChildren(tr);
    }
    // @formatter:on
}
