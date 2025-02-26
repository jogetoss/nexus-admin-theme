package org.joget.marketplace;

import de.bripkens.gravatar.DefaultImage;
import de.bripkens.gravatar.Gravatar;
import de.bripkens.gravatar.Rating;
import java.util.HashMap;
import java.util.Map;
import org.joget.apps.app.service.AppUtil;
import org.joget.apps.userview.service.UserviewUtil;
import org.joget.commons.util.ResourceBundleUtil;
import org.joget.commons.util.StringUtil;
import org.joget.directory.model.User;
import org.joget.directory.model.service.DirectoryUtil;
import org.joget.plugin.enterprise.XadminTheme;


public class NexusAdminTheme extends XadminTheme {
    private final static String MESSAGE_PATH = "message/NexusAdminTheme";

    @Override
    public String getName() {
        return "Nexus Admin Theme";
    }

    @Override
    public String getVersion() {
        return "8.1.0";
    }

    @Override
    public String getDescription() {
        return "A universal responsive Userview Theme based on open source X-Admin template";
    }

    @Override
    public String getLabel() {
        return getName();
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }  
    
    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClass().getName(), "/properties/NexusAdminTheme.json", null, true, MESSAGE_PATH);
    }
    
    @Override
    public String getJsCssLib(Map<String, Object> data) {
        String jsCssLink = super.getJsCssLib(data);
        jsCssLink += "<link rel=\"stylesheet\" href=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/font/Geist/css/font.css\"/>\n";
        jsCssLink += getInternalJsCssLib(data);
        jsCssLink += "<link rel=\"stylesheet\" href=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/css/NexusAdminTheme.css\">\n";
        jsCssLink += generateCssVars();
        jsCssLink += "<script type=\"text/javascript\" src=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/js/NexusAdminTheme.js\"></script>\n";
        
        if (!getPropertyString("xbackgroundImage").isEmpty()) {
            jsCssLink += "<style> .x-admin-sm body { background: url('" + getPropertyString("xbackgroundImage") + "'); background-size: cover; background-repeat: no-repeat;}</style>";
        }
        
        return jsCssLink;
    }
    
    protected String generateCssVars() {
        String cssVars = ":root {";
        String background = "#F5F7F9";
        String headerColor = "#FFFFFF";
        String navBackground = "#001428";
        String navLinkBackground = "#001428";
        String navLinkColor = "#BBBBBB";
        String navActiveLinkBackground = "#409EFF";
        String navActiveLinkColor = "#FFFFFF";
        String buttonColor = "#FFFFFF";
        String buttonBackground = "#409EFF";
        String primaryColor = "#0D6EFD";
        String primaryColor2 = "rgba(13, 110, 253, 0.10)";
        String primaryColor3 = "rgba(13, 110, 253, 0.25)";
        String fontColor = "#303133";
        String linkColor = "#0D6EFD";
        String linkActiveColor = "#2D8CF0";
        String footerBackground = "#F5F7F9";
        String footerColor = "#303133";
        String fontSize = "14px";
        String borderRadius = "4px";
        String sideBarWidth = "220px";

        // Override variables with custom properties if available
        if (!getPropertyString("xbackground").isEmpty()) {
            background = getPropertyString("xbackground");
        }
        if (!getPropertyString("xheaderColor").isEmpty()) {
            headerColor = getPropertyString("xheaderColor");
        }
        if (!getPropertyString("xnavBackground").isEmpty()) {
            navBackground = getPropertyString("xnavBackground");
        }
        if (!getPropertyString("xnavLinkBackground").isEmpty()) {
            navLinkBackground = getPropertyString("xnavLinkBackground");
        }
        if (!getPropertyString("xnavLinkColor").isEmpty()) {
            navLinkColor = getPropertyString("xnavLinkColor");
        }
        if (!getPropertyString("xnavActiveLinkBackground").isEmpty()) {
            navActiveLinkBackground = getPropertyString("xnavActiveLinkBackground");
        }
        if (!getPropertyString("xnavActiveLinkColor").isEmpty()) {
            navActiveLinkColor = getPropertyString("xnavActiveLinkColor");
        }
        if (!getPropertyString("xbuttonColor").isEmpty()) {
            buttonColor = getPropertyString("xbuttonColor");
        }
        if (!getPropertyString("xbuttonBackground").isEmpty()) {
            buttonBackground = getPropertyString("xbuttonBackground");
        }
        if (!getPropertyString("xprimaryColor").isEmpty()) {
            primaryColor = getPropertyString("xprimaryColor");
            primaryColor2 = hexToRGBA(primaryColor, 0.1);
            primaryColor3 = hexToRGBA(primaryColor, 0.25);
        }
        if (!getPropertyString("xfontColor").isEmpty()) {
            fontColor = getPropertyString("xfontColor");
        }
        if (!getPropertyString("xfooterBackground").isEmpty()) {
            footerBackground = getPropertyString("xfooterBackground");
        }
        if (!getPropertyString("xfooterColor").isEmpty()) {
            footerColor = getPropertyString("xfooterColor");
        }
        if (!getPropertyString("xlinkColor").isEmpty()) {
            linkColor = getPropertyString("xlinkColor");
        }
        if (!getPropertyString("xlinkActiveColor").isEmpty()) {
            linkActiveColor = getPropertyString("xlinkActiveColor");
        }
        if (!getPropertyString("xfontSize").isEmpty()) {
            fontSize = getPropertyString("xfontSize");
        }
        if (!getPropertyString("xborderRadius").isEmpty()) {
            borderRadius = getPropertyString("xborderRadius");
        }
        if (!getPropertyString("xsideBarWidth").isEmpty()) {
            sideBarWidth = getPropertyString("xsideBarWidth");
        }
        
        
        // Generate CSS variables
        cssVars += "--background: " + background + ";";
        cssVars += "--header-color: " + headerColor + ";";
        cssVars += "--nav-background: " + navBackground + ";";
        cssVars += "--nav-link-background: " + navLinkBackground + ";";
        cssVars += "--nav-link-color: " + navLinkColor + ";";
        cssVars += "--nav-active-link-background: " + navActiveLinkBackground + ";";
        cssVars += "--nav-active-link-color: " + navActiveLinkColor + ";";
        cssVars += "--button-color: " + buttonColor + ";";
        cssVars += "--button-background: " + buttonBackground + ";";
        cssVars += "--primary-color: " + primaryColor + ";";
        cssVars += "--primary-color2: " + primaryColor2 + ";";
        cssVars += "--primary-color3: " + primaryColor3 + ";";
        cssVars += "--font-color: " + fontColor + ";";
        cssVars += "--link-color: " + linkColor + ";";
        cssVars += "--link-active-color: " + linkActiveColor + ";";
        cssVars += "--footer-background: " + footerBackground + ";";
        cssVars += "--footer-color: " + footerColor + ";";
        cssVars += "--font-size: " + fontSize + ";";
        cssVars += "--border-radius: " + borderRadius + ";";
        cssVars += "--sidebarWidth: " + sideBarWidth + ";";
        cssVars += "}";
        
        // Embed the CSS variables into a <style> tag
        String style = "<style>" + cssVars + "</style>";
    
        return style;
    }
    
    @Override
    protected String getUserMenu(Map<String, Object> data) {
        String html = "";
        if ((Boolean) data.get("is_logged_in")) {
            User user = (User) data.get("user");
            String email = user.getEmail();
            if (email == null) {
                email = "";
            }
            if (email.contains(";")) {
                email = email.split(";")[0];
            }
            if (email.contains(",")) {
                email = email.split(",")[0];
            }

            String profileImageTag = "";
            if (getPropertyString("userImage").isEmpty()) {
                String url = (email != null && !email.isEmpty()) ? 
                    new Gravatar()
                        .setSize(50)
                        .setHttps(true)
                        .setRating(Rating.PARENTAL_GUIDANCE_SUGGESTED)
                        .setStandardDefaultImage(DefaultImage.IDENTICON)
                        .getUrl(email)
                    : "//www.gravatar.com/avatar/default?d=identicon";
                profileImageTag = "<img class=\"gravatar\" alt=\"gravatar\" width=\"30\" height=\"30\" data-lazysrc=\""+url+"\" onError=\"this.onerror = '';this.style.display='none';\"/> ";
            } else if ("hashVariable".equals(getPropertyString("userImage"))) {
                String url = AppUtil.processHashVariable(getPropertyString("userImageUrlHash"), null, StringUtil.TYPE_HTML, null, AppUtil.getCurrentAppDefinition());
                if (AppUtil.containsHashVariable(url) || url == null || url.isEmpty()) {
                    url = data.get("context_path") + "/" + getPathName() + "/user.png";
                }
                profileImageTag = "<img alt=\"profile-img profile\" width=\"30\" height=\"30\" src=\""+url+"\" /> ";
            } else {
                profileImageTag = "<i class=\"icon iconfont\">&#xe6b8;</i> ";
            }
            
            html += "<ul class=\"layui-nav right user-menu\" lay-filter=\"\">\n";
            
            html += getInbox(data);
            
            html += "<li class=\"layui-nav-item\">\n";
            html += "<a href=\"javascript:;\">"+profileImageTag+StringUtil.stripHtmlTag(DirectoryUtil.getUserFullName(user), new String[]{}) + "</a>\n";
            html += "<dl class=\"layui-nav-child\">\n";
            
            if (!"true".equals(getPropertyString("profile")) && !user.getReadonly()) {
                String profileLabel = ResourceBundleUtil.getMessage("theme.universal.profile");
                html += "<dd><a onclick=\"xadmin.open('"+profileLabel+"','"+data.get("base_link") + PROFILE+"?embed=true')\">"+profileLabel+"</a></dd>\n";
            }
            
            Object[] shortcut = (Object[]) getProperty("userMenu");
            if (shortcut != null && shortcut.length > 0) {
                for (Object o : shortcut) {
                    Map link = (HashMap) o;
                    String href = link.get("href").toString();
                    String label = link.get("label").toString();
                    String target = (link.get("target") == null)?"":link.get("target").toString();
                    if ("divider".equalsIgnoreCase(label)) {
                        html += "<dd class=\"divider\"></dd>\n";
                    } else if (href.isEmpty()) {
                         html += "<dd class=\"dropdown-menu-title\"><span>" + label + "</span></dd>\n";
                    } else {
                        if (!href.contains("/")) {
                            href = data.get("base_link") + href;
                        }
                        String attr = "";
                        if ("tab".equalsIgnoreCase(target)) {
                            attr = "onclick=\"xadmin.add_tab('"+StringUtil.escapeString(label, StringUtil.TYPE_HTML + ";" + StringUtil.TYPE_JAVASCIPT, null)+"','"+href+"')\"";
                        } else if ("popup".equalsIgnoreCase(target)) {
                            attr = "onclick=\"xadmin.open('"+StringUtil.escapeString(label, StringUtil.TYPE_HTML + ";" + StringUtil.TYPE_JAVASCIPT, null)+"','"+href+"')\"";
                        } else {
                            attr = "href=\"" + href + "\" target=\""+target+"\"";
                        }
                        html += "<dd><a "+attr+">" + label + "</a></dd>\n";
                    }
                }
            }
            html += "<dd><a href=\"" + data.get("logout_link") + "\">"+ResourceBundleUtil.getMessage("theme.universal.logout")+"</a></dd>\n";
            html += "</dl></li>\n";
            html += "<li id=\"help-container\"></li></ul>";
        } else {
            html += "<ul class=\"layui-nav right\" lay-filter=\"\">\n";
            html += "<li class=\"layui-nav-item\">\n";
            html += "<a href=\"" + data.get("login_link") + "\"><i class=\"icon iconfont\">&#xe6b8;</i> "+ResourceBundleUtil.getMessage("ubuilder.login") + "</a>\n";
            html += "</li>\n";
            html += "<li id=\"help-container\"></li></ul>";
        }
        return html;
    }
    
    @Override
    public String getLayout(Map<String, Object> data) {
        if (!"true".equalsIgnoreCase(getPropertyString("disabledFineFont"))) {
            if (!getPropertyString("xbackgroundImage").isEmpty()) {
                data.put("html_attributes", "class=\"x-admin-sm transparent-mode\"");
            } else {
                data.put("html_attributes", "class=\"x-admin-sm\"");
            }
        }
        if ((getRequestParameter("menuId") == null || getUserview().getPropertyString("homeMenuId").equals(getRequestParameter("menuId")))) {
            data.put("body_classes", data.get("body_classes").toString());
        }
        if (!((Boolean) data.get("embed")) && !getPropertyString("logo").isEmpty()) {
            data.put("body_classes", ((data.get("body_classes") != null)?data.get("body_classes").toString():"") +" has-logo");
        }
        if (!((Boolean) data.get("embed"))) {
            if (!isIndex()) {
                data.put("body_classes", ((data.get("body_classes") != null)?data.get("body_classes").toString():"") +" inner-frame");
            } else {
                data.put("body_classes", ((data.get("body_classes") != null)?data.get("body_classes").toString():"") +" index-window");
            }
        }

        return UserviewUtil.getTemplate(this, data, "/templates/userview/layout.ftl");
    }
    
    public static String hexToRGBA(String hex, double opacity) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1); // Remove "#"
        }

        if (hex.length() != 6) {
            return null; // Invalid hex code
        }

        try {
            int r = Integer.parseInt(hex.substring(0, 2), 16);
            int g = Integer.parseInt(hex.substring(2, 4), 16);
            int b = Integer.parseInt(hex.substring(4, 6), 16);

            // Ensure opacity is between 0 and 1
            opacity = Math.min(1, Math.max(0, opacity));

            return String.format("rgba(%d, %d, %d, %.2f)", r, g, b, opacity);
        } catch (NumberFormatException e) {
            return null; // Invalid hex characters
        }
    }
}
