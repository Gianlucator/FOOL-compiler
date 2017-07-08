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
push 0
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
push getFabonicci39
js
print
halt

getFabonicci39:
cfp
lra
push 1
lfp
add
lw
push 20
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
push 1
lfp
add
lw
lfp
push fooFabonicci39
js
b label1
label0:
push 42
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

fooFabonicci39:
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
push getFabonicci39
js
srv
sra
pop
pop
sfp
lrv
lra
js
