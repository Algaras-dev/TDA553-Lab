# Uppgift 2
__Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts smartare, dummare eller tunnare?__
- enterWorkshop ligger i controllern, men innehåller domänlogik (modellansvar)
- DrawPanel lagrar domänstate
- Kollisionslogiken tar JPanel som argument (beror på en specifik grafisk implementation)
- **Smartare**:
    - Modellen borde äga alla domänreglerna och state-ändringar
- **Dummare**:
    - Vyn DrawPanel ska inte hålla domänstate (workshop list)
- **Tunnare**:
    - Controllern borde inte innehålla logik som enterWorkshop eller kollisioner


__Vilka av dessa brister åtgärdade ni med er nya design från del 3? Hur då? Vilka brister åtgärdade ni inte?__
- Vyn DrawPanel innehåller inte en workshop list
- Ny WorkshopManager klass i modellen som hanterar domänlogik för workshops
- Kollisionslogiken använder Dimension i stället för JPanel

Åtgärdade inte:
- Även om tryEnterWorkshop nu ligger i modellen (i WorkshopManager), så tar den in BoundsService, och BoundsService beror på WorldView. Modellen har alltså fortfarande ett indirekt beroende till vyn.
    - getImageSize gör att bildstorlek blir källan för hitboxes. Då blir logik beroende av view-resurser
- Vyn DrawPanel lagrar fortfarande state (vilka objekter som finns) tillsammans med modellen.