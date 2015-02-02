/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author lvaleriano
 */
public class C_ComponentFrame {
    public void setEnableJPanelComponents(Component []components, boolean Enabled, String... ExComponent){
        if(components.length > 0){
            for (Component component : components) {
                boolean OriginalValueEnabled = Enabled;
                for(int i=0; i<ExComponent.length; i++){
                    if(component.getName().equals(ExComponent[i])){
                        Enabled = !Enabled;
                        i = ExComponent.length;
                    }
                }
                component.setEnabled(Enabled);
                Enabled = OriginalValueEnabled;
            }
        }
    }
    public void setEnableJPanelComponentsWithCheckBox(JPanel panel, JCheckBox checkbox, String... ExComponent){
        if(checkbox.isSelected()){
            setEnableJPanelComponents(panel.getComponents(), true, ExComponent);
        }else{
            setEnableJPanelComponents(panel.getComponents(), false, ExComponent);
        }
    }
}
