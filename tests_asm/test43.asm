push 0
push 0
lhp
push 0
add
sw
push 7
lhp
push 1
add
sw
push Cane
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
add
shp
lhp
push 1
lhp
push 0
add
sw
push 6
lhp
push 1
add
sw
push BullDog
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
add
shp
lhp
lop
sro
push -3
lfp
add
lw
sop
lfp
lfp
push 0
smo
lop
push -2
add
lw
js
lop
sro
push -3
lfp
add
lw
sop
lfp
lfp
push 2
smo
lop
push -2
add
lw
js
add
print
halt

getAge6Animale7:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
lro
sop
js

isAlive7Animale7:
cfp
lra
push -4
lop
add
lw
srv
sra
pop
sfp
lrv
lra
lro
sop
js

Animale:
lmo
push 0
beq getAge6Animale7
lmo
push 1
beq isAlive7Animale7

quantoViveAncora16Cane4:
cfp
lra
push -4
lop
add
lw
push 1
beq label4
push 0
b label5
label4:
push -3
lop
add
lw
push 15
beq label8
push 0
b label9
label8:
push 1
label9:
push 1
beq label6
push 1
b label7
label6:
push 15
push -3
lop
add
lw
add
label7:
label5:
srv
sra
pop
sfp
lrv
lra
lro
sop
js

Cane:
lmo
push 0
beq getAge6Animale7
lmo
push 1
beq isAlive7Animale7
lmo
push 2
beq quantoViveAncora16Cane4

quantoViveAncora16BullDog7:
cfp
lra
push -4
lop
add
lw
push 1
beq label13
push 0
b label14
label13:
push -3
lop
add
lw
push 8
beq label17
push 0
b label18
label17:
push 1
label18:
push 1
beq label15
push 1
b label16
label15:
push 8
push -3
lop
add
lw
add
label16:
label14:
srv
sra
pop
sfp
lrv
lra
lro
sop
js

BullDog:
lmo
push 0
beq getAge6Animale7
lmo
push 1
beq isAlive7Animale7
lmo
push 2
beq quantoViveAncora16BullDog7
halt
