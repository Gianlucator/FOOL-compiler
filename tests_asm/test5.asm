push function12
push function13
push function14
push function15
push 0
push 4
lhp
push 65078524
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
push -2
lfp
add
lw
lhp
sw
push 1
lhp
add
shp
nullhalt

function0:
cfp
lra
push 1
lfp
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 5
lfp
lfp
push -2
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
lfp
lw
push -3
lfp
lw
add
lw
js
srv
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

function3:
cfp
lra
push -3
lfp
lw
add
lw
push -4
lfp
lw
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function6:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

function7:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function8:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

function9:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function10:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

function11:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function12:
cfp
lra
push 2
push 1
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function13:
cfp
lra
push 3
push 1
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function14:
cfp
lra
push 2
push 1
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function15:
cfp
lra
push 3
push 1
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js
