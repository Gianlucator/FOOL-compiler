push 0
push function2
push function3
push 8
push function4
push function5
push 0
nullnullprint
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 1
beq label0
push -2
lfp
lw
add
lw
b label1
label0:
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
add
lw
add
add
label1:
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push -1
lfp
lw
add
lw
push -2
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

function2:
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

function3:
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

function4:
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

function5:
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
