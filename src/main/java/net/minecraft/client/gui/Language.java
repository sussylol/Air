package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;

import java.io.IOException;
import java.util.Map;

public class Language extends Screen {
    /**
     * The parent Gui screen
     */
    protected Screen parentScreen;

    /**
     * The List GuiSlot object reference.
     */
    private Language.List list;

    /**
     * Reference to the GameSettings object.
     */
    private final GameSettings game_settings_3;

    /**
     * Reference to the LanguageManager object.
     */
    private final LanguageManager languageManager;

    /**
     * A button which allows the user to determine if the Unicode font should be forced.
     */
    private GuiOptionButton forceUnicodeFontBtn;

    /**
     * The button to confirm the current settings.
     */
    private GuiOptionButton confirmSettingsBtn;

    public Language(Screen screen, GameSettings gameSettingsObj, LanguageManager manager) {
        this.parentScreen = screen;
        this.game_settings_3 = gameSettingsObj;
        this.languageManager = manager;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui() {
        this.buttonList.add(this.forceUnicodeFontBtn = new GuiOptionButton(100, this.width / 2 - 155, this.height - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT)));
        this.buttonList.add(this.confirmSettingsBtn = new GuiOptionButton(6, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.done")));
        this.list = new Language.List(this.mc);
        this.list.registerScrollButtons(7, 8);
    }

    /**
     * Handles mouse input.
     */
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 5:
                    break;

                case 6:
                    this.mc.displayGuiScreen(this.parentScreen);
                    break;

                case 100:
                    if (button instanceof GuiOptionButton) {
                        this.game_settings_3.setOptionValue(((GuiOptionButton) button).returnEnumOptions(), 1);
                        button.displayString = this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
                        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
                        int i = scaledresolution.getScaledWidth();
                        int j = scaledresolution.getScaledHeight();
                        this.setWorldAndResolution(this.mc, i, j);
                    }

                    break;

                default:
                    this.list.actionPerformed(button);
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.list.drawScreen(mouseX, mouseY, partialTicks);
        this.drawCenteredString(this.fontRendererObj, I18n.format("options.language"), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, "(" + I18n.format("options.languageWarning") + ")", this.width / 2, this.height - 56, 8421504);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    class List extends GuiSlot {
        private final java.util.List<String> langCodeList = Lists.newArrayList();
        private final Map<String, net.minecraft.client.resources.Language> languageMap = Maps.newHashMap();

        public List(Minecraft mcIn) {
            super(mcIn, Language.this.width, Language.this.height, 32, Language.this.height - 65 + 4, 18);

            for (net.minecraft.client.resources.Language language : Language.this.languageManager.getLanguages()) {
                this.languageMap.put(language.getLanguageCode(), language);
                this.langCodeList.add(language.getLanguageCode());
            }
        }

        protected int getSize() {
            return this.langCodeList.size();
        }

        protected void elementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
            net.minecraft.client.resources.Language language = this.languageMap.get(this.langCodeList.get(slotIndex));
            Language.this.languageManager.setCurrentLanguage(language);
            Language.this.game_settings_3.language = language.getLanguageCode();
            this.mc.refreshResources();
            Language.this.fontRendererObj.setUnicodeFlag(Language.this.languageManager.isCurrentLocaleUnicode() || Language.this.game_settings_3.forceUnicodeFont);
            Language.this.fontRendererObj.setBidiFlag(Language.this.languageManager.isCurrentLanguageBidirectional());
            Language.this.confirmSettingsBtn.displayString = I18n.format("gui.done");
            Language.this.forceUnicodeFontBtn.displayString = Language.this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
            Language.this.game_settings_3.saveOptions();
        }

        protected boolean isSelected(int slotIndex) {
            return this.langCodeList.get(slotIndex).equals(Language.this.languageManager.getCurrentLanguage().getLanguageCode());
        }

        protected int getContentHeight() {
            return this.getSize() * 18;
        }

        protected void drawBackground() {
            Language.this.drawDefaultBackground();
        }

        protected void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int mouseXIn, int mouseYIn) {
            Language.this.fontRendererObj.setBidiFlag(true);
            Language.this.drawCenteredString(Language.this.fontRendererObj, this.languageMap.get(this.langCodeList.get(entryID)).toString(), this.width / 2, p_180791_3_ + 1, 16777215);
            Language.this.fontRendererObj.setBidiFlag(Language.this.languageManager.getCurrentLanguage().isBidirectional());
        }
    }
}
