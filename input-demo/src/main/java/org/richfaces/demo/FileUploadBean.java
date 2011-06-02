/*
 * JBoss, Home of Professional Open Source
 * Copyright ${year}, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.richfaces.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * @author Konstantin Mishin
 *
 */
@ManagedBean
@SessionScoped
public class FileUploadBean {
    private String acceptedTypes;
    private boolean disabled = false;
    private boolean noDuplicate = false;
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    // public void paint(OutputStream stream, Object object) throws IOException {
    // stream.write(item.getData());
    // }

    public void listener(FileUploadEvent event) throws Exception {
        file = event.getUploadedFile();
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setNoDuplicate(boolean noDuplicate) {
        this.noDuplicate = noDuplicate;
    }

    public boolean isNoDuplicate() {
        return noDuplicate;
    }

    public void setAcceptedTypes(String acceptedTypes) {
        this.acceptedTypes = acceptedTypes;
    }

    public String getAcceptedTypes() {
        return acceptedTypes;
    }

    public void updateAttribute(AjaxBehaviorEvent event) throws AbortProcessingException {
        UIComponent component = (UIComponent) event.getSource();
        String attributeName = (String) component.findComponent("name").getAttributes().get("value");
        Object attributeValue = component.findComponent("value").getAttributes().get("value");
        component.findComponent("fu").getAttributes().put(attributeName, attributeValue);
    }
}
