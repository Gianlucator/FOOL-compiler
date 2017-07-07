push 0
push 0
lhp
sw
push 1
lhp
add
shp
push 7
lhp
sw
push 1
lhp
add
shp
push 4
lhp
sw
push 1
lhp
add
shp
push 20
lhp
sw
push 1
lhp
add
shp
lhp
push 1
lhp
sw
push 1
lhp
add
shp
push 6
lhp
sw
push 1
lhp
add
shp
push 4
lhp
sw
push 1
lhp
add
shp
push 21
lhp
sw
push 1
lhp
add
shp
lhp
push -3
lfp
add
lw
sop
lfp
lfp
push getAgeAnimale
js
push -3
lfp
add
lw
sop
lfp
lfp
push quantoViveAncoraBullDog
js
add
print
halt

getAgeAnimale:
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
js

isAliveAnimale:
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
js

quantoViveAncoraCane:
cfp
lra
push -4
lop
add
lw
push 1
beq label0
push 0
b label1
label0:
push -3
lop
add
lw
push 15
beq label4
push 0
b label5
label4:
push 1
label5:
push 1
beq label2
push 1
b label3
label2:
push 15
push -3
lop
add
lw
add
label3:
label1:
srv
sra
pop
sfp
lrv
lra
js

quantoViveAncoraBullDog:
cfp
lra
push -4
lop
add
lw
push 1
beq label6
push 0
b label7
label6:
push -3
lop
add
lw
push 8
beq label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
push 1
b label9
label8:
push 8
push -3
lop
add
lw
add
label9:
label7:
srv
sra
pop
sfp
lrv
lra
js
