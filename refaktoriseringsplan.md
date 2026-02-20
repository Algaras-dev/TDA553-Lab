# Uppgift 2: Beroenden
__Vilka klasser är beroende av varandra som inte borde vara det?__
- Dubbeltberoende mellan CarView och CarController
- CarController är beroende av CarView och DrawPanel (CC har för mycket insyn i GUI-detaljer och blir väldigt tight kopplad)
- Hög koppling mellan Vehicle-relaterade klasser och UI-relaterade klasser
    - DrawPanel är beroende av Workshop och Volvo240 (konkreta klasser - bryter mot DIP)

__Finns det starkare beroenden än nödvändigt?__
- Ex: frame.drawPanel.getImageSize används i CarController

# Uppgift 3: Ansvarsområden
__Vilka ansvarsområden har era klasser?__
- 

__Vilka anledningar har de att förändras?__
- Ingen väldefinierad _main_ metod, det görs från `CarController` och `DrawPanel`

__På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?__
- Största problemet är CarController

# Uppgift 4: Ny design

- Ta bort b

__Refaktoriseringsplan__
1. Skapa CarViewListenerSource och flytta ut addXListener och getGasAmount till interfacet. Låt CarView implementera det. Ta bort carC-fältet i CarView
2. Skapa WorldView (getWorldSize, getImageSize, removeDrawable, repaintWorld). Låt DrawPanel implementera WorldView. Låt CarView ha DrawPanel: WorldView.
3. Ändra Collisions (CollisionsService) så att den tar Dimension i stället för att vara beroende av JPanel
4. Skapa VehicleSimulator som äger List<Vehicle> + tick() + metoder för att kontrollera fordon (flytta looperna från CarController hit)
5. Byta ut actionPerformed i CarController::TimerListener med
6. 
