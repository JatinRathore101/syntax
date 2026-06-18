// XML Handling in Java — Parse and create XML using DOM (Document Object Model)
// DOM loads the entire XML into memory as a tree of nodes
// Built into the Java standard library — no extra dependencies needed
//
// This file works with employees.xml in the same folder.

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // ─── 1. READ an existing XML file ────────────────────────────────────
        // employees.xml lives in the same folder — open it and look at it first
        File xmlFile = new File("employees.xml");
        Document doc = builder.parse(xmlFile);
        doc.getDocumentElement().normalize(); // clean up whitespace-only text nodes

        System.out.println("Root element: " + doc.getDocumentElement().getTagName());

        NodeList employees = doc.getElementsByTagName("employee");
        System.out.println("Total employees: " + employees.getLength());
        System.out.println();

        for (int i = 0; i < employees.getLength(); i++) {
            Element emp = (Element) employees.item(i);

            String id         = emp.getAttribute("id");
            String name       = emp.getElementsByTagName("name").item(0).getTextContent();
            String role       = emp.getElementsByTagName("role").item(0).getTextContent();
            String department = emp.getElementsByTagName("department").item(0).getTextContent();

            // Read an attribute from a child element
            Element salaryEl  = (Element) emp.getElementsByTagName("salary").item(0);
            String  currency  = salaryEl.getAttribute("currency");
            String  salary    = salaryEl.getTextContent();

            System.out.printf("ID: %s | %-8s | %-12s | %s | %s %s%n",
                              id, name, role, department, currency, salary);
        }

        // ─── 2. MODIFY the DOM and write to a new file ───────────────────────
        // Add a new employee node to the in-memory document
        Element root   = doc.getDocumentElement();
        Element newEmp = doc.createElement("employee");
        newEmp.setAttribute("id", "4");

        Element newName = doc.createElement("name");
        newName.appendChild(doc.createTextNode("Dave"));
        Element newRole = doc.createElement("role");
        newRole.appendChild(doc.createTextNode("DevOps"));
        Element newDept = doc.createElement("department");
        newDept.appendChild(doc.createTextNode("Infrastructure"));
        Element newSalary = doc.createElement("salary");
        newSalary.setAttribute("currency", "USD");
        newSalary.appendChild(doc.createTextNode("95000"));

        newEmp.appendChild(newName);
        newEmp.appendChild(newRole);
        newEmp.appendChild(newDept);
        newEmp.appendChild(newSalary);
        root.appendChild(newEmp);

        // Write the updated DOM to a separate output file (leaves employees.xml untouched)
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(new DOMSource(doc), new StreamResult(new File("employees_updated.xml")));

        System.out.println("\nWrote updated XML to: employees_updated.xml");
        System.out.println("(employees.xml is unchanged — it is the sample reference file)");
    }
}
