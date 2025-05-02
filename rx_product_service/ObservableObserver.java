package com.example.rx_product_service;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;

public class ObservableObserver {

    public Observable<String> createObservable() {
        return Observable.just("Observable1","Observalbe2");
    }

    public Observable<String> createObservableFromCreate() {
        return Observable.create(
                emitter -> {
                    emitter.onNext("Observable Create 1");
                    emitter.onNext("Observable Create 2");
                    emitter.onNext("Observable Create 3");
                    emitter.onComplete();
                }
        );
    }



    public Observable<String> fetchObservable() {
        Observable<String> observable=this.createObservable();
        observable.subscribe(
                item->System.out.println("From Observable===>"+item),
                error->System.out.println("Error===>"+error),
                ()->System.out.println("Completed"));
        return observable;
    }

    public Single<String> createSingle() {
        return Single.just("Single Observable");
    }

    public Single<String> fetchSingleObservable() {
        Single<String> single = this.createSingle();
        single.subscribe(
                   item->System.out.println("Single Observable===>"+item),
                error->System.out.println("Error===>"+error)
        );
        return single;
    }

    public Maybe<String> createMaybe() {
        return Maybe.just("Maybe Observable");
    }

    public Maybe<String> fetchMaybeObservable() {
        Maybe<String> maybe = this.createMaybe();
        maybe.subscribe(
                item->System.out.println("Maybe Observable===>"+item),
                error->System.out.println("Error===>"+error),
                ()->System.out.println("Completed")
        );
        return maybe;
    }
}
