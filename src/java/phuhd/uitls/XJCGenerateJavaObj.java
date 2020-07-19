/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.uitls;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Duy Phu
 */
public class XJCGenerateJavaObj {

    private final String input = "";
    private final String output = "src/java/";

    public void generateObj() {
        try {
            SchemaCompiler sc = XJC.createSchemaCompiler();
            sc.setErrorListener(new ErrorListener() {
                @Override
                public void error(SAXParseException e) {
                    System.out.println("error : " + e.getMessage());
                }

                @Override
                public void fatalError(SAXParseException e) {
                    System.out.println("fatal : " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void warning(SAXParseException e) {
                    System.out.println("warning : " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void info(SAXParseException e) {
                    System.out.println("info : " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
                }
            });
            sc.forcePackageName("phuhd.jaxb");
            File schema = new File("src/java/phuhd/schema/ProductSchema.xsd");
            InputSource is = new InputSource(schema.toURI().toString());
            sc.parseSchema(is);
            S2JJAXBModel model = sc.bind();
            JCodeModel codeModel = model.generateCode(null, null);
            codeModel.build(new File(output));
            System.out.println("Finished generate onject");
        } catch (IOException e) {
            System.out.println("XJCGenerateObject - IO: " + e.getMessage());
        }

    }

    public static <T> String marshalData(T t) {
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(t, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
