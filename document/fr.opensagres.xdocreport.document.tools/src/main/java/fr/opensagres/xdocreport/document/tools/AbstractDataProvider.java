/**
 * Copyright (C) 2011-2015 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.opensagres.xdocreport.document.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fr.opensagres.xdocreport.core.io.IOUtils;
import fr.opensagres.xdocreport.document.tools.internal.StringBuilderOutputStream;

public abstract class AbstractDataProvider
    implements IDataProvider
{

    private final InputStream data;

    private final InputStream properties;

    public AbstractDataProvider( InputStream data, InputStream properties )
    {
        this.data = data;
        this.properties = properties;
    }

    public InputStream getData()
    {
        return data;
    }

    public InputStream getProperties()
    {
        return properties;
    }

    public String getDataAsString()
        throws IOException
    {
        // InputStreamReader isr = new InputStreamReader(getData(), "UTF8");
        StringBuilderOutputStream writer = new StringBuilderOutputStream();
        IOUtils.copy( getData(), writer );
        String data = writer.toString();
        System.out.print("JSON Data: " + data);
        return data;
    }

}
