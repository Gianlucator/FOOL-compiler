push 0
push 20
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
push 36
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
push 0
lfp
push getFabonicci
js
print
halt

getFabonicci:
cfp
lra
push 1
lfp
add
lw
push 20
beq label14
push 0
b label15
label14:
push 1
label15:
push 1
beq label12
lfp
push 1
lfp
add
lw
lfp
push fooFabonicci
js
b label13
label12:
push 42
label13:
srv
sra
pop
pop
sfp
lrv
lra
js

fooFabonicci:
cfp
lra
lfp
push 1
lfp
add
lw
push 1
add
lfp
push getFabonicci
js
srv
sra
pop
pop
sfp
lrv
lra
js
